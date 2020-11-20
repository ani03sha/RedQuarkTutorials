const cronJob = require('./jobs');
const {
    readFile,
    writeFile,
    deleteFile 
} = require('./files');
const {
    sendEmail
} = require('./emails');

readFile.readFile();
writeFile.writeFile();
deleteFile.deleteFile();
sendEmail.sendEmail();
cronJob.run();