<template>
  <div>
    <a-form-model
      ref="genInfoForm"
      :label-col="labelCol"
      :wrapper-col="wrapperCol"
    >
      <a-row>
        <a-col :span="12">
          <a-form-model-item label="生成模板">
            <a-select v-model="info.tplCategory" placeholder="请选择">
              <a-select-option value="crud">单表（增删改查）</a-select-option>
              <a-select-option value="tree">树表（增删改查）</a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item label="生成包路径">
            <a-input placeholder="请输入生成包路径" v-model="info.packageName" />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item label="生成模块名">
            <a-input placeholder="请输入生成模块名" v-model="info.moduleName" />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item label="生成业务名">
            <a-input placeholder="请输入生成业务名" v-model="info.businessName" />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item label="生成功能名">
            <a-input placeholder="请输入生成功能名" v-model="info.functionName" />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item label="生成上级菜单">
            <a-tree-select
              v-model="info.parentMenuId"
              :tree-data="menus"
              style="width: 100%"
              :dropdown-style="{ maxHeight: '400px', overflow: 'auto' }"
              placeholder="请选择系统菜单"
              :replaceFields="treeReplaceFields"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="24" :pull="3">
          <a-form-model-item label="生成代码方式">
            <a-radio-group name="radioGroup" v-model="info.genType" :default-value="1">
              <a-radio :value="'0'">zip压缩包</a-radio>
              <a-radio :value="'1'">自定义路径</a-radio>
            </a-radio-group>
          </a-form-model-item>
        </a-col>
        <a-col :span="24" :pull="3" v-if="info.genType == '1'">
          <a-form-model-item label="生成代码方式">
            <a-input placeholder="自定义路径" v-model="info.genPath" />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row v-if="info.tplCategory == 'tree'">
        <h4 class="form-header">其他信息</h4>
        <a-col :span="12">
          <a-form-model-item label="树编码字段">
            <a-select v-model="info.treeCode" placeholder="请选择">
              <a-select-option
                v-for="item in info.columns"
                :key="item.columnName"
                :value="item.columnName">
                {{ item.columnName + '：' + item.columnComment }}
              </a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item label="树父编码字段">
            <a-select v-model="info.treeParentCode" placeholder="请选择">
              <a-select-option
                v-for="item in info.columns"
                :key="item.columnName"
                :value="item.columnName">
                {{ item.columnName + '：' + item.columnComment }}
              </a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item label="树名称字段">
            <a-select v-model="info.treeName" placeholder="请选择">
              <a-select-option
                v-for="item in info.columns"
                :key="item.columnName"
                :value="item.columnName">
                {{ item.columnName + '：' + item.columnComment }}
              </a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
      </a-row>
    </a-form-model>
  </div>
</template>
<script>
export default {
  name: 'GenInfoForm',
  props: {
    info: {
      type: Object,
      default: null
    },
    menus: {
      type: Array,
      default: null
    }
  },
  data () {
    return {
      visible: false,
      loading: false,
      // 模态框数据
      data: {},
      labelCol: {
        xs: { span: 12 },
        sm: { span: 6 }
      },
      wrapperCol: {
        xs: { span: 24 },
        sm: { span: 18 }
      },
      // 类型数据字典
      typeOptions: [],
      // 类型数据字典
      statusOptions: [],
      treeReplaceFields: {
        children: 'children',
        title: 'menuName',
        key: 'menuId',
        value: 'menuId'
      }
    }
  },
  created () {
    console.log('测试')
    console.log(this.info)
  },
  methods: {
    // 关闭模态框
    close () {
      this.visible = false
    },
    // 打开抽屉(由外面的组件调用)
    show (data) {
      if (data) {
        this.data = data
      }
      this.visible = true
    }
  }
}
</script>
