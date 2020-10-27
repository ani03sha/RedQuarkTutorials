const cronJob = require('./jobs');
const {
    readFile,
    writeFile 
} = require('./files');

readFile.readFile();
writeFile.writeFile();
cronJob.run();