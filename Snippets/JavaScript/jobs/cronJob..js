// Import module
const cron = require('node-cron');

// This expression defines the cron
const CRON_EXPRESSION = "*/10 * * * * *";

// Actual task to execute i.e., your business logic
const jobToExecute = () => {
    console.log('Running a task every ten seconds');
}

// This function runs the job based on the CRON_EXPRESSION
const run = () => {
    cron.schedule(CRON_EXPRESSION, () => {
        jobToExecute();
    });
}

module.exports = { run };