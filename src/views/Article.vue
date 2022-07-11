<template>
    <div class="articleList">
        <panel v-for="articles in articleList" :article="articles" :key="articles.articleId"/>
        <div class="pager">
            <el-pagination
                    :page-size="pageInfo.pageSize"
                    :pager-count="11"
                    layout="prev, pager, next"
                    :total="pageInfo.total"
                    @current-change="currentChange"
                    :hide-on-single-page="true"
            >
            </el-pagination>
        </div>
    </div>

</template>

<script>
    import {request} from "../requests/requests";
    import Panel from "../components/article/Panel";
    import scrollToTop from "../util/scrollToTop";
    export default {
    name: "Article",
      components:{
      Panel
      },
    data(){
      return {
        articleList:'',
        // background:"url(http://192.168.3.212:8080/img/background1.png)",
        colors : ['#ffbca1','#ffc7d2','#bbc3ff','Tomato','DodgerBlue'],
        currentPage:1,
        totalPage:'',
        preIsDisable:'disable',
        pageInfo:''
      }
    },
      methods:{
        currentChange(page){
            this.currentPage = parseInt(page);
        },
        backgroundColor(){
          this.num ++
          return this.colors[this.num % 4]
        },
        nextPage(){
          this.currentPage++
        },
        prePage(){
          this.currentPage--
        }
      },
    created() {
      request({
        url:'/article/'+this.$route.params.categoryId,
        params:{
          currentPage:this.currentPage
        }
      }).then((result)=>{
        if(result.data.list.length==0){
          this.$message.error('抱歉,该分类下无文章')
        }else {
          this.articleList = result.data.list
          this.pageInfo = result.data
        }
      })
      this.num = 0
    },
      beforeRouteUpdate(to,from,next){
        request({
          url:'/article/'+to.params.categoryId,
          params:{
            currentPage:1
          }
        }).then((result)=>{
          if(result.data.list.length==0){
            this.$message.error('抱歉,该分类下无文章')
          }else {
            this.articleList = result.data.list
            this.pageInfo = result.data
          }
        })
        next()
      },
      watch:{
        'currentPage'(){
          scrollToTop(500)
          request({
            url:'/article/'+this.$route.params.categoryId,
            params:{
              currentPage:this.currentPage
            }
          }).then((result)=>{
            this.articleList = result.data.list
          })
          if(this.currentPage==1){
            this.preIsDisable = true
          }else{
            this.preIsDisable = false
          }

        }
      }
  }
</script>

<style lang="less">
    .articleList{
        box-sizing: border-box;
        width: 100%;
        /*padding-top: 30px;*/
        padding:30px 75px;
        min-height: 95vh;
        /*margin:0 50px;*/
    }
    @media screen and (max-width:800px ){
        .articleList{
            width: 100%;
            padding:30px 0px;
        }
    }
    .el-pager {
        li {
            margin: 0 5px;
            background-color: #ffd594 !important;
            color: white;
            padding:0 !important;
            border-radius: 5px;
            min-width: 30px !important;
        }
        .active{
            color: #ff9b99 !important;
        }

        .number:hover{
            color:#ff9b99 !important;
        }
    }
    .pager{
        width: 100%;
        text-align: center;
        margin-bottom: 20px;

        .btn-prev,.btn-next{
            background-color: #ffd594 !important;
            padding-right: 6px!important;
            padding-left: 6px!important;
            min-width: 30px !important;
            border-radius: 5px;
            color: white;
            &:hover{
                color:#ff9b99;
            }
        }

    }
</style>