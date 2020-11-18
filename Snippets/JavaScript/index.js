const cronJob = require('./jobs');
const {
    readFile,
    writeFile,
    deleteFile 
} = require('./files');

readFile.readFile();
writeFile.writeFile();
deleteFile.deleteFile();
cronJob.run();