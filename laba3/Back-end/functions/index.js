const functions = require('firebase-functions');

const json = [
    {
        "title": "Monocrystal",
        "year": "15 kW",
        "description":  "60 Ah",
        "rating": "< 2 years",
        "tags": "Somewhere, Long St., 1256",
        "poster": "https://cdn10.bigcommerce.com/s-3yc5xwvk/products/3293/images/4469/VBHN330SA16__61039.1483059860.1280.1280.png?c=2"
    },
    {
        "title": "Polycrystal",
        "year": "25 kW",
        "description":  "100 Ah",
        "rating": "3 - 5 years",
        "tags": "Fangorn, Newcastle St., 3030",
        "poster": "https://images-na.ssl-images-amazon.com/images/I/61JPOTziZbL._SX425_.jpg"
    },
    {
        "title": "CIS",
        "year": "38 kW",
        "description":  "200 Ah",
        "rating": "5 - 10 years",
        "tags": "Isengard, Seaside St., 1796",
        "poster": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5EqiCR3SJn5WtKMuJ4VekkCpEut-uxF76GiP_bYrP3-OT6aiw"
    },
        {
        "title": "Monocrystal",
        "year": "50 kW",
        "description":  "60 Ah",
        "rating": "10+ years",
        "tags": "Shire, Bagend St., 5656",
        "poster": "https://cdn10.bigcommerce.com/s-3yc5xwvk/products/3293/images/4469/VBHN330SA16__61039.1483059860.1280.1280.png?c=2"
    },
    {
        "title": "Polycrystal",
        "year": "150 kW",
        "description":  "100 Ah",
        "rating": "3 - 5 years",
        "tags": "Bree, Lilit St., 1237",
        "poster": "https://images-na.ssl-images-amazon.com/images/I/61JPOTziZbL._SX425_.jpg"
    },
    {
        "title": "CIS",
        "year": "15 kW",
        "description":  "200 Ah",
        "rating": "1 - 2 years",
        "tags": "Tirit, Rat St., 4568",
        "poster": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5EqiCR3SJn5WtKMuJ4VekkCpEut-uxF76GiP_bYrP3-OT6aiw"
    },
        {
        "title": "Monocrystal",
        "year": "15 kW",
        "description":  "60 Ah",
        "rating": "< 2 years",
        "tags": "Minas, One St., 7846",
        "poster": "https://cdn10.bigcommerce.com/s-3yc5xwvk/products/3293/images/4469/VBHN330SA16__61039.1483059860.1280.1280.png?c=2"
    },
    {
        "title": "Polycrystal",
        "year": "25 kW",
        "description":  "200 Ah",
        "rating": "3 - 5 years",
        "tags": "Gondor, Tree St., 4896",
        "poster": "https://images-na.ssl-images-amazon.com/images/I/61JPOTziZbL._SX425_.jpg"
    },
    {
        "title": "CIS",
        "year": "38 kW",
        "description":  "100 Ah",
        "rating": "5 - 10 years",
        "tags": "Isengard, Orcside St., 6666",
        "poster": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5EqiCR3SJn5WtKMuJ4VekkCpEut-uxF76GiP_bYrP3-OT6aiw"
    },
        {
        "title": "Monocrystal",
        "year": "150 kW",
        "description":  "200 Ah",
        "rating": "10+ years",
        "tags": "Fangorn, Entling St., 1256",
        "poster": "https://cdn10.bigcommerce.com/s-3yc5xwvk/products/3293/images/4469/VBHN330SA16__61039.1483059860.1280.1280.png?c=2"
    },
    {
        "title": "Polycrystal",
        "year": "25 kW",
        "description":  "60 Ah",
        "rating": "10+ years",
        "tags": "Mordor, Melkor St., 3030",
        "poster": "https://images-na.ssl-images-amazon.com/images/I/61JPOTziZbL._SX425_.jpg"
    },
    {
        "title": "CIS",
        "year": "100 kW",
        "description":  "200 Ah",
        "rating": "5 - 10 years",
        "tags": "Mirkwood, Greenleaf St., 1796",
        "poster": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5EqiCR3SJn5WtKMuJ4VekkCpEut-uxF76GiP_bYrP3-OT6aiw"
    },
    {
        "title": "Polycrystal",
        "year": "25 kW",
        "description":  "60 Ah",
        "rating": "10+ years",
        "tags": "Mordor, Melkor St., 3030",
        "poster": "https://images-na.ssl-images-amazon.com/images/I/61JPOTziZbL._SX425_.jpg"
    },
    {
        "title": "CIS",
        "year": "38 kW",
        "description":  "100 Ah",
        "rating": "5 - 10 years",
        "tags": "Isengard, Orcside St., 6666",
        "poster": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5EqiCR3SJn5WtKMuJ4VekkCpEut-uxF76GiP_bYrP3-OT6aiw"
    },
    {
        "title": "Monocrystal",
        "year": "150 kW",
        "description":  "200 Ah",
        "rating": "10+ years",
        "tags": "Fangorn, Entling St., 1256",
        "poster": "https://cdn10.bigcommerce.com/s-3yc5xwvk/products/3293/images/4469/VBHN330SA16__61039.1483059860.1280.1280.png?c=2"
    }
];
exports.solar = functions.https.onRequest((request, response) => {response.send(json);
});
