const hexlantAPI = 'http://106.10.58.158:3000/';
const url = hexlantAPI + 'v1/rpc';
const Web3 = require('web3');
const web3 = new Web3(url);

const startBlock = 7298000;
const endBlock = 7298517;
const targetAddress = '0x782F8853443AB778784DdF03D6835d7d068641F6';

async function getHistory(start, end, address) {
  let targetBlock = start;
  let lastBlock = end;   
  let myHistory = [];       
  try {
    while (targetBlock < lastBlock) {
      console.log(targetBlock);
      const thisBlock = await web3.eth.getBlock(targetBlock, true);
      const tasks = thisBlock.transactions.map(async tx => {
        const sender = tx.from;
        var receiver = tx.to;
        if (!receiver) return;
        const code = await web3.eth.getCode(receiver); 
        if (code === '0x' && [sender, receiver].includes(address)) {
          myHistory.push({
            type: 'eth',
            sender,
            receiver,
            value: web3.utils.fromWei(tx.value.toString(), 'ether'), 
            hash: tx.hash
          });
        } else {
          const inputData = tx.input;
          const functionSignature = inputData.substr(0, 10);
          const payload = '0x' + inputData.substr(10);
          if (functionSignature == '0xa9059cbb') {
            const decodeParams = web3.eth.abi.decodeParameters(['address', 'uint256'], payload);
            receiver = decodeParams[0];
            if ([sender, receiver].includes(address)) {
              myHistory.push({
                type: 'erc',
                sender,
                receiver,
                value: web3.utils.fromWei(decodeParams[1].toString(), 'ether'),
                hash: tx.hash
              });
            } 
          }
        }
      })
      await Promise.all(tasks);
      targetBlock++;
    }
    return myHistory;
  } catch (e) {
    console.log(e);
  }
}

(async () => {
  const latestBlock = await web3.eth.getBlockNumber(); // 가장 최신의 블록을 사용할 때 endBlock 대신에 사용
  const result = await getHistory(startBlock, endBlock, targetAddress);
  console.log(result);
})()

