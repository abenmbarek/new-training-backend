const path = require('path');
const merge = require('webpack-merge');
const webpackCommonConfig = require('./webpack.common.js');

let config = merge(webpackCommonConfig, {
    context: path.resolve(__dirname, 'apps'),
    entry: {
        customers: './customers/customersMain.js'
    },
    output: {
        path: path.resolve(__dirname, '../webapp/javascript/vue/'),
        filename: '[name].bundle.js'
    }
});

module.exports = config;