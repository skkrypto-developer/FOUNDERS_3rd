var finance_abi = [{
        "anonymous": false,
        "inputs": [{
                "indexed": false,
                "internalType": "string",
                "name": "purpose",
                "type": "string"
            },
            {
                "indexed": false,
                "internalType": "string",
                "name": "subject",
                "type": "string"
            },
            {
                "indexed": false,
                "internalType": "string",
                "name": "price",
                "type": "string"
            },
            {
                "indexed": false,
                "internalType": "string",
                "name": "amount",
                "type": "string"
            },
            {
                "indexed": false,
                "internalType": "string",
                "name": "totalprice",
                "type": "string"
            }
        ],
        "name": "Newfinance",
        "type": "event"
    },
    {
        "inputs": [],
        "name": "Council",
        "outputs": [{
            "internalType": "address",
            "name": "",
            "type": "address"
        }],
        "stateMutability": "view",
        "type": "function"
    },
    {
        "inputs": [],
        "name": "Council_received_wei",
        "outputs": [{
            "internalType": "uint256",
            "name": "",
            "type": "uint256"
        }],
        "stateMutability": "view",
        "type": "function"
    },
    {
        "inputs": [{
            "internalType": "uint256",
            "name": "_number",
            "type": "uint256"
        }],
        "name": "getResult",
        "outputs": [{
                "internalType": "string",
                "name": "getpurpose",
                "type": "string"
            },
            {
                "internalType": "string",
                "name": "getsubject",
                "type": "string"
            },
            {
                "internalType": "string",
                "name": "getprice",
                "type": "string"
            },
            {
                "internalType": "string",
                "name": "getamount",
                "type": "string"
            },
            {
                "internalType": "string",
                "name": "gettotalprice",
                "type": "string"
            }
        ],
        "stateMutability": "view",
        "type": "function"
    },
    {
        "inputs": [],
        "name": "last_sender",
        "outputs": [{
            "internalType": "address",
            "name": "",
            "type": "address"
        }],
        "stateMutability": "view",
        "type": "function"
    },
    {
        "inputs": [{
                "internalType": "string",
                "name": "_purpose",
                "type": "string"
            },
            {
                "internalType": "string",
                "name": "_subject",
                "type": "string"
            },
            {
                "internalType": "string",
                "name": "_price",
                "type": "string"
            },
            {
                "internalType": "string",
                "name": "_amount",
                "type": "string"
            },
            {
                "internalType": "string",
                "name": "_totalprice",
                "type": "string"
            }
        ],
        "name": "putResult",
        "outputs": [],
        "stateMutability": "nonpayable",
        "type": "function"
    },
    {
        "inputs": [],
        "name": "sending",
        "outputs": [],
        "stateMutability": "payable",
        "type": "function"
    },
    {
        "inputs": [{
            "internalType": "uint256",
            "name": "",
            "type": "uint256"
        }],
        "name": "useresults",
        "outputs": [{
                "internalType": "string",
                "name": "purpose",
                "type": "string"
            },
            {
                "internalType": "string",
                "name": "subject",
                "type": "string"
            },
            {
                "internalType": "string",
                "name": "price",
                "type": "string"
            },
            {
                "internalType": "string",
                "name": "amount",
                "type": "string"
            },
            {
                "internalType": "string",
                "name": "totalprice",
                "type": "string"
            }
        ],
        "stateMutability": "view",
        "type": "function"
    }
]