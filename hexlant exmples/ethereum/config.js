var infuraApiKey = '';

module.exports = {
    accounts: [
        {
            address: '0x25212d4810A25b1a7048783F1bc3F79E1a138f3f',    // TODO
            key: 'f990b0afaf4835db5613f752432fc12743ac27a7da48eb2acc9729e9218764c1'        // TODO
        },
    ],
    networks: {
        local: 'http://127.0.0.1:7545',
        ropsten: 'https://ropsten.infura.io/v3/' + infuraApiKey,
        rinkeby: 'https://rinkeby.infura.io/v3/' + infuraApiKey,
        kovan: 'https://kovan.infura.io/v3/' + infuraApiKey,
        mainnet: 'https://mainnet.infura.io/v3/' + infuraApiKey,
        hexlant: 'http://106.10.58.158:3000/v1/rpc',
    },
    deployInfo: {
        targetFile: 'erc20.sol',
        targetContract: 'ERC20',
        name: 'SAEBOM',             // TODO
        symbol: 'BOM',           // TODO
        supply: '1000000000',           // TODO
    },
    contract: {
        address: '0x5e44EDE67EDd810bcb2812C5E6941C2FffeA00C3',
    },
    gas: {
        limit: 2000000,
        price: 30000000000, 
    },
    settings: {
        selectedAccountIndex: 0,
        selectedNetwork: 'hexlant',
    }
};
