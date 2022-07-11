const path = require('path');//引入path模块


// 导入compression-webpack-plugin
const CompressionWebpackPlugin = require('compression-webpack-plugin');
// 定义压缩文件类型
const productionGzipExtensions = ['js', 'css']

function resolve(dir){
  return path.resolve(__dirname,dir)//path.resolve(__dirname)设置绝对路径
}
module.exports={

  publicPath:'/',
  chainWebpack:(config)=>{
    config.resolve.alias.set('@',resolve('./src')).set('assets',resolve('./src/assets'))
  },
  devServer: {
    open:true,
    port:8081,
    proxy: {
      '/api': {
        target: 'http://192.168.3.173:8080',   //代理接口
        changeOrigin: true,
        pathRewrite: {
          '^/api': ''    //代理的路径
        }
      }
    }
  },
  configureWebpack:{
    externals: {
      'vue': 'Vue',
      'vuex': 'Vuex',
      'vue-router': 'VueRouter',
      'element-ui': 'ELEMENT',
      'Axios':'axios'
    },
    plugins: [
      new CompressionWebpackPlugin({
        filename: '[path].gz[query]',
        algorithm: 'gzip',
        test: new RegExp('\\.(' + productionGzipExtensions.join('|') + ')$'),//匹配文件名
        threshold: 10240,//对10K以上的数据进行压缩
        minRatio: 0.8,
        deleteOriginalAssets:false,//是否删除源文件
      })
    ]
  }
}