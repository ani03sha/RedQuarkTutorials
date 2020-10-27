// Import the core node js fs module
const fs = require('fs');

const contentToWrite = 'This content will be written into the file';

const writeFile = () => {
    fs.writeFile('files/sample-file-to-write.txt', contentToWrite, (err) => {
        if (err) {
            throw err;
        }
        console.log('File is saved!');
    });
}

module.exports = { writeFile };
