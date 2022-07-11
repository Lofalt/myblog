// import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store/index'
// import elementUI from 'element-ui'
import {baseURL} from "../api.config";
import less from  'less'
// import axios from 'axios'
import hljs from 'highlight.js';
import 'highlight.js/styles/github-gist.css'
import vuex from "vuex"


Vue.use(less)
Vue.use(ELEMENT)
Vue.config.productionTip = false


new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')

Vue.directive('highlight', el => {
  let blocks = el.querySelectorAll('pre code');
  Array.prototype.forEach.call(blocks, hljs.highlightBlock);
});

