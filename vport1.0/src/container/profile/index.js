import React from 'react'
import {Form, Input, Button, message, Icon, Checkbox, Radio, DatePicker} from 'antd'
import './index.less'


const FormItem = Form.Item;
const RadioGroup = Radio.Group

class StuProfile extends React.Component{

    handleSubmit = ()=>{
        let userInfo = this.props.form.getFieldsValue();
        this.props.form.validateFields((err, values)=>{
            if(!err){
                message.success(`Congratulations! ${userInfo.userName}`)
            }
        })
    }
    render(){

        const { getFieldDecorator } = this.props.form;
        return(
            <div className="login-wrap">
                <div className="wrap">
                    <Form layout='horizontal' style={{width: 300, margin: "0px auto"}} className="form">
                        <FormItem>
                            {
                                getFieldDecorator('email', {
                                    rules: [
                                        {
                                            required: true,
                                            message: "please input your email"
                                        },
                                        {
                                            pattern: /^\w+@.*$/g,
                                            message: 'unrecognized email format'
                                        }
                                    ]
                                })(
                                    <Input prefix={<Icon type='mail'></Icon>} type='email' placeholder="email" />
                                )
                            }
                        </FormItem>
                        <FormItem>
                            {
                                getFieldDecorator('userPwd', {
                                    rules: [{
                                        required: true,
                                        message: "please input password"
                                    }]
                                })(
                                    <Input prefix={<Icon type='lock'></Icon>} type='password' placeholder="password" />
                                )
                            }

                        </FormItem>
                        <FormItem>
                            {
                                getFieldDecorator('userName', {
                                    rules: [{
                                        required: true,
                                        message: "please input username"
                                    }]
                                })(
                                    <Input prefix={<Icon type='user'></Icon>} placeholder="username" />
                                )
                            }

                        </FormItem>
                        <FormItem>
                            {
                                getFieldDecorator('sex', {
                                    rules: [{
                                        required: true,
                                        message: "please input sex"
                                    }]
                                })(
                                    <RadioGroup >
                                        <Radio value="male" style={{color: '#eeeeee'}}>male</Radio>
                                        <Radio value="female" style={{color: '#eeeeee'}}>female</Radio>
                                    </RadioGroup>
                                )
                            }
                        </FormItem>
                        <FormItem>
                            {
                                getFieldDecorator('type', {
                                    rules: [{
                                        required: true,
                                        message: "please input sex"
                                    }]
                                })(
                                    <RadioGroup style={{color: '#eeeeee'}}>
                                        <Radio value="student" style={{color: '#eeeeee'}}>student</Radio>
                                        <Radio value="trainer" style={{color: '#eeeeee'}}>trainer</Radio>
                                    </RadioGroup>
                                )
                            }
                        </FormItem>
                        <FormItem>
                            {
                                getFieldDecorator('birthday', {
                                    initialValue: '2018-08-08',
                                    rules: [{

                                    }]
                                })(
                                    <DatePicker></DatePicker>
                                )
                            }
                        </FormItem>
                        <FormItem style={{float: 'left'}}>
                            {
                                getFieldDecorator('remember', {
                                    valuePropName: 'checked', // checkbox的初始化
                                    initialValue: true,
                                    rules: [{
                                        required: true,
                                        message: "please input password"
                                    }]
                                })(
                                    <Checkbox className="remember-name">remember username</Checkbox>
                                )
                            }
                        </FormItem>
                        <FormItem>
                            <Button type='primary' onClick={this.handleSubmit}>Submit</Button>
                        </FormItem>
                    </Form>
                </div>
            </div>

        )
    }
}
export default Form.create()(StuProfile)