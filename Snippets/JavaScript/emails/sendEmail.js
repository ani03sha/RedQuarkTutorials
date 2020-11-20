const nodemailer = require('nodemailer');

const toEmail = '<recipient-email-id>';
const fromEmail = '<sender-email-id>';
const subject = '<subject-of-the-email>';
const message = '<message-of-the-email>';

const transporter = nodemailer.createTransport({
    service: 'gmail',
    auth: {
        user: '<your-email-id>',
        pass: '<your-password>'
    }
});

const sendEmail = () => {
    const details = {
        from: fromEmail,
        to: toEmail,
        subject: subject,
        html: message
    };

    transporter.sendMail(details, (error, data) => {
        if (error) {
            console.log(error);
        } else {
            console.log(data);
        }
    });
};

module.exports = {
    sendEmail
};