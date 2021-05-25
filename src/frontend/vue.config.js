// vue.config.js
module.exports = {
    pages: {
        index: {
            entry: 'src/Home/main.js',
            template: 'public/index.html',
            filename: 'home.html',
            title: 'Home Page',
            chunks: ['chunk-vendors', 'chunk-common', 'index']
        },

        work: {
            // entry for the page
            entry: 'src/Work/main.js',
            // the source template
            template: 'public/index.html',
            // output as dist/index.html
            filename: 'work.html',
            // when using title option,
            // template title tag needs to be <title><%= htmlWebpackPlugin.options.title %></title>
            title: 'Work Page',
            chunks: ['chunk-vendors', 'chunk-common', 'index']
        }
    },

    // https://cli.vuejs.org/config/#devserver-proxy
    devServer: {
        port: 3000,
        proxy: {
            '/api': {
                target: 'http://localhost:8080',
                nws: true,
                changeOrigin: true
            }
        }
    }
}