const functions = require('firebase-functions');

const json = [
    {
        "panelType": "Monocrystal",
        "power": "15 kW",
        "capacity":  "60 Ah",
        "usagePeriod": "< 2 years",
        "address": "Somewhere, Long St., 1256",
        "photoUrl": "https://cdn10.bigcommerce.com/s-3yc5xwvk/products/3293/images/4469/VBHN330SA16__61039.1483059860.1280.1280.png?c=2"
    },
    {
        "panelType": "Polycrystal",
        "power": "25 kW",
        "capacity":  "100 Ah",
        "usagePeriod": "3 - 5 years",
        "address": "Fangorn, Newcastle St., 3030",
        "photoUrl": "https://images-na.ssl-images-amazon.com/images/I/61JPOTziZbL._SX425_.jpg"
    },
    {
        "panelType": "CIS",
        "power": "38 kW",
        "capacity":  "200 Ah",
        "usagePeriod": "5 - 10 years",
        "address": "Isengard, Seaside St., 1796",
        "photoUrl": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5EqiCR3SJn5WtKMuJ4VekkCpEut-uxF76GiP_bYrP3-OT6aiw"
    },
        {
        "panelType": "Monocrystal",
        "power": "50 kW",
        "capacity":  "60 Ah",
        "usagePeriod": "10+ years",
        "address": "Shire, Bagend St., 5656",
        "photoUrl": "https://cdn10.bigcommerce.com/s-3yc5xwvk/products/3293/images/4469/VBHN330SA16__61039.1483059860.1280.1280.png?c=2"
    },
    {
        "panelType": "Polycrystal",
        "power": "150 kW",
        "capacity":  "100 Ah",
        "usagePeriod": "3 - 5 years",
        "address": "Bree, Lilit St., 1237",
        "photoUrl": "https://images-na.ssl-images-amazon.com/images/I/61JPOTziZbL._SX425_.jpg"
    },
    {
        "panelType": "CIS",
        "power": "15 kW",
        "capacity":  "200 Ah",
        "usagePeriod": "1 - 2 years",
        "address": "Tirit, Rat St., 4568",
        "photoUrl": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5EqiCR3SJn5WtKMuJ4VekkCpEut-uxF76GiP_bYrP3-OT6aiw"
    },
        {
        "panelType": "Monocrystal",
        "power": "15 kW",
        "capacity":  "60 Ah",
        "usagePeriod": "< 2 years",
        "address": "Minas, One St., 7846",
        "photoUrl": "https://cdn10.bigcommerce.com/s-3yc5xwvk/products/3293/images/4469/VBHN330SA16__61039.1483059860.1280.1280.png?c=2"
    },
    {
        "panelType": "Polycrystal",
        "power": "25 kW",
        "capacity":  "200 Ah",
        "usagePeriod": "3 - 5 years",
        "address": "Gondor, Tree St., 4896",
        "photoUrl": "https://images-na.ssl-images-amazon.com/images/I/61JPOTziZbL._SX425_.jpg"
    },
    {
        "panelType": "CIS",
        "power": "38 kW",
        "capacity":  "100 Ah",
        "usagePeriod": "5 - 10 years",
        "address": "Isengard, Orcside St., 6666",
        "photoUrl": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5EqiCR3SJn5WtKMuJ4VekkCpEut-uxF76GiP_bYrP3-OT6aiw"
    },
        {
        "panelType": "Monocrystal",
        "power": "150 kW",
        "capacity":  "200 Ah",
        "usagePeriod": "10+ years",
        "address": "Fangorn, Entling St., 1256",
        "photoUrl": "https://cdn10.bigcommerce.com/s-3yc5xwvk/products/3293/images/4469/VBHN330SA16__61039.1483059860.1280.1280.png?c=2"
    },
    {
        "panelType": "Polycrystal",
        "power": "25 kW",
        "capacity":  "60 Ah",
        "usagePeriod": "10+ years",
        "address": "Mordor, Melkor St., 3030",
        "photoUrl": "https://images-na.ssl-images-amazon.com/images/I/61JPOTziZbL._SX425_.jpg"
    },
    {
        "panelType": "CIS",
        "power": "100 kW",
        "capacity":  "200 Ah",
        "usagePeriod": "5 - 10 years",
        "address": "Mirkwood, Greenleaf St., 1796",
        "photoUrl": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5EqiCR3SJn5WtKMuJ4VekkCpEut-uxF76GiP_bYrP3-OT6aiw"
    },
    {
        "panelType": "Polycrystal",
        "power": "25 kW",
        "capacity":  "60 Ah",
        "usagePeriod": "10+ years",
        "address": "Mordor, Melkor St., 3030",
        "photoUrl": "https://images-na.ssl-images-amazon.com/images/I/61JPOTziZbL._SX425_.jpg"
    },
    {
        "panelType": "CIS",
        "power": "38 kW",
        "capacity":  "100 Ah",
        "usagePeriod": "5 - 10 years",
        "address": "Isengard, Orcside St., 6666",
        "photoUrl": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5EqiCR3SJn5WtKMuJ4VekkCpEut-uxF76GiP_bYrP3-OT6aiw"
    },
    {
        "panelType": "Monocrystal",
        "power": "150 kW",
        "capacity":  "200 Ah",
        "usagePeriod": "10+ years",
        "address": "Fangorn, Entling St., 1256",
        "photoUrl": "https://cdn10.bigcommerce.com/s-3yc5xwvk/products/3293/images/4469/VBHN330SA16__61039.1483059860.1280.1280.png?c=2"
    }
];
exports.solar = functions.https.onRequest((request, response) => {response.send(json);
});
