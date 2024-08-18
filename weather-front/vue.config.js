module.exports = {
  devServer: {
    port: 80,
    proxy:{
      '/test':{
        target:'http://app:8080',
        changeOrigin:true,
        pathRewrite:{
          "^/api":""
        }
      },
      '/jh':{
        target:'https://api.openweathermap.org',
        changeOrigin:true,
        pathRewrite:{
          "^/jh":""
        }
      }
    }
  }
}

