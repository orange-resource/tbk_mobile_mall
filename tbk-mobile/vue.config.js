module.exports = {
    devServer: {
        port: 80,
        host: '0.0.0.0',
        https: false, // https:{type:Boolean}
        open: false, //配置自动启动浏览器
        disableHostCheck: true,
        // proxy: 'http://localhost:8238' // 配置跨域处理,只有一个代理
        proxy: {
            '/tbk': {
                target: 'http://localhost:8238/tbk',   // 需要请求的地址
                ws: false,
                changeOrigin: true,  // 是否跨域
                pathRewrite: {
                    '^/tbk': '/'  // 替换target中的请求地址，也就是说，在请求的时候，url用'/proxy'代替'http://ip.taobao.com'
                }
            }

        },  // 配置多个代理
    },
};
