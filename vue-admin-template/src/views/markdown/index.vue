<template>
  <div class="app-container">
    <el-row :gutter="20">
      <el-col :span="20">
        <el-input v-model="input" placeholder="请输入内容"></el-input>
      </el-col>
      <el-col :span="2">
        <el-select v-model="value" placeholder="请选择">
          <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>      
      </el-col>
      <el-col :span="2">
          <el-button type="primary"  style="float:right;">主要按钮</el-button>
      </el-col>
    </el-row>  
    <el-row>
      <el-col :span="24">
      <v-md-editor
        v-model="content"
        :disabled-menus="[]"
        height="600px"
        width="100%"
        @save="saveFromEditor"
        @upload-image="handleUploadImage"
      />
      </el-col>
    </el-row>
  </div>
</template>

<script>
import example from './example'
import VMdEditor from '@kangc/v-md-editor'
import enUS from '@kangc/v-md-editor/lib/lang/en-US'
import githubTheme from '@kangc/v-md-editor/lib/theme/github.js'
import createEmojiPlugin from '@kangc/v-md-editor/lib/plugins/emoji/index'
import createTodoListPlugin from '@kangc/v-md-editor/lib/plugins/todo-list/index'
import createMermaidPlugin from '@kangc/v-md-editor/lib/plugins/mermaid/npm'
import createTipPlugin from '@kangc/v-md-editor/lib/plugins/tip/index'
import hljs from 'highlight.js'
import Axios from 'axios'

VMdEditor.use(githubTheme, {
  Hljs: hljs,
  config: {
    toc: {
      includeLevel: [3, 4]
    }
  }
})
VMdEditor.lang.use('en-US', enUS)
VMdEditor.use(createEmojiPlugin())
VMdEditor.use(createTodoListPlugin())
VMdEditor.use(createMermaidPlugin())
VMdEditor.use(createTipPlugin())

export default {

  components: {
    VMdEditor
  },
  data: function() {
    return {
      content: example,
      options: [{
          value: '选项1',
          label: '黄金糕'
        }, {
          value: '选项2',
          label: '双皮奶'
        }, {
          value: '选项3',
          label: '蚵仔煎'
        }, {
          value: '选项4',
          label: '龙须面'
        }, {
          value: '选项5',
          label: '北京烤鸭'
        }],
      input: ''
    }
  },
  methods: {
    saveFromEditor(text, html) {
      console.log(text)
      console.log(html)
    }, 
    saveTheContent(title, type, content){

    },
    handleUploadImage(event, insertImage, files) {
      // 拿到 files 之后上传到文件服务器，然后向编辑框中插入对应的内容
      console.log(files);
      let formData = new FormData();
      formData.append('file', files[0]);
      formData.append('number', 'Bug#10234');
      Axios.post('/upload-test', formData, {
        headers: {
          'Content-Type': 'multipart/form-data'
        }
      }).then((response) =>{
        console.log(response.data)
        insertImage({
        url:
          'http://localhost:8123/' + response.data,
        desc: '七龙珠',
        // width: 'auto',
        // height: 'auto',
      });
      }).catch(() => {
        console.log('FAIL');
      })
      // 此处只做示例
      
    }
  }
}

</script>

<style>

@import '~@kangc/v-md-editor/lib/style/base-editor.css';
@import '~@kangc/v-md-editor/lib/theme/style/github.css';
@import '~@kangc/v-md-editor/lib/plugins/emoji/emoji.css';
@import '~@kangc/v-md-editor/lib/plugins/todo-list/todo-list.css';
@import '~@kangc/v-md-editor/lib/plugins/mermaid/mermaid.css';
@import '~@kangc/v-md-editor/lib/plugins/tip/tip.css';
</style>
