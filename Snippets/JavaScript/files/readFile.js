// Import the module
const fs = require('fs');

// This function reads the file and prints the data on the console using the callback function
const readFile = () => {
    fs.readFile('files/sample-text-file.txt', 'utf8', (err, data) => {
        if (err) {
            return console.log(err);
        }
        console.log(data);
    });
}

module.exports = { readFile };