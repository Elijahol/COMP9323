const mongoose = require('mongoose')
// 连接mongodb，并且使用ballon这个集合
const DB_URL = 'mongodb://127.0.0.1:27017/test-chat';
mongoose.connect(DB_URL)
mongoose.connection.on('connected', function () {
    console.log('mongo connect success')
})

const models = {
    user: {
        'name': {type: String, require:true},
        'password': {type: String, require:true},
        'icon': {type:String},
        'email': {type:String},
        'birthday':{type:String},
        'weight':{type:String},
        'height':{type:String},
        'phone':{type:String},
        'city':{type:String},
        'gender':{type:String},
        'role':{type:String},
        'award':{type:String},
        'experience':{type:String}
        // 如果是boss还有两个字段

    },
    chat:{

    }
}
for(let m in models){
    mongoose.model(m, new mongoose.Schema(models[m]))
}
module.exports = {
    getModel:function(name){
        return mongoose.model(name)
    }
}