<template>
    <div class="footer">
        <div><span>@Lofalt</span>备案号: <a class="footLink" href="http://www.beian.miit.gov.cn/">粤ICP备20002960号</a></div>
        <div>本站已经有惊无险地运行了{{day}}天啦!</div>
    </div>
</template>

<script>
  export default {
    name: "Footer",
    data(){
      return {
        day:''
      }
    },
    created() {
      let now  = new Date().getTime()
      let pre = new Date(2020,2,20).getTime()
      this.day = Math.floor((now-pre) / (1000*60*60*24))
    }
  }
</script>

<style lang="less" scoped>
    .footer{
        min-height: 5%;
        flex: 1;
        background-color: #ffc48c;
        border-top: #e8e8e8 1px solid;
        text-align: center;
        color: white;
        div span{
            margin-right: 15px;
        }
    }
    .footLink:link{
        color:white;
    }
    .footLink:visited{
        color:white;
    }
</style>