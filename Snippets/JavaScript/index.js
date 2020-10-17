const cronJob = require("./jobs");
const readFile = require("./files");

readFile.readFile();
cronJob.run();