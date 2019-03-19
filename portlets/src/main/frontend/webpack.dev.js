const path = require('path');
const merge = require('webpack-merge');
const webpackCommonConfig = require('./webpack.common.js');
const CopyWebpackPlugin = require('copy-webpack-plugin');

// change the server path to your server location path
const exoServerPath = "/home/exo/Documents/GestionStock/platform-5.1.0/";

let config = merge(webpackCommonConfig, {
    context: path.resolve(__dirname, 'apps'),
    entry: {
        customers: './customers/customersMain.js'
    },
    output: {
        path: path.resolve(__dirname, exoServerPath + '/webapps/addon-template-portlets/javascript/vue/'),
        filename: '[name].bundle.js'
    },
    devtool: 'inline-source-map'
});

config.plugins.push(new CopyWebpackPlugin([{from: 'src/main/webapp/lang/*.json', to: './lang', flatten: true}]));

module.exports = config;