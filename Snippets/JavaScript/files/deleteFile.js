// Import the core node js fs module
const fs = require('fs');
// Relative path of the file to be deleted
const fileName = 'files/sample-file-to-write.txt';

// This function deletes the file
const deleteFile = () => {
    fs.unlink(fileName, (err) => {
        if (err) {
            throw err;
        }
        console.log("File deleted successfully");
    });
}

module.exports = { deleteFile };