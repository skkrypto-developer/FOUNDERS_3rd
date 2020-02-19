const hexlantAPI = 'http://106.10.58.158:3000';
const request = require('request-promise-native');
const Web3 = require('web3');
const web3 = new Web3(hexlantAPI + '/v1/rpc');


const targetAddress = '0x782F8853443AB778784DdF03D6835d7d068641F6';

(async function getHistory(address) {
  try {
    const history = await request({ url: `${hexlantAPI}/v1/addresses/${address}/transactions`, json: true });
    /*qs: {
      type: 'erc20',
      contractAddress: '',
    }, json: true }); 
    console.log(history) */
    history.forEach(tx => {
      console.log(tx.from)
    })
  } catch (e) {
    console.log(e);
  }
})(targetAddress);
