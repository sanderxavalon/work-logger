<template>
  <div class="app-container">
    <v-md-editor
      v-model="content"
      :disabled-menus="[]"
      height="600px"
      @save="saveFromEditor"
      @upload-image="handleUploadImage"
    />
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
      content: example
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
