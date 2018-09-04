import React from 'react'
import {Form, Input, Button, message, Icon, Checkbox} from 'antd'
import { connect } from 'react-redux'
import { NavLink, Redirect } from 'react-router-dom'
import './index.less'
import { delMsg, login } from "./../../redux/user.redux";

const FormItem = Form.Item;

@connect(
    state=>state.user,
    { login, delMsg }
)
class FormLogin extends React.Component{

    constructor(){
        super();
        this.state={
            email:'',
            password:'',
            history:''
        }
    }

    onChange = (e)=>{
        this.setState({
            [e.target.name]: e.target.value
        })
    };

    handleSubmit = ()=>{
        this.props.form.validateFields((err, values)=>{
            if(!err){
                console.log('查看login提交的信息');
                console.log(this.state);
                this.props.login(this.state);
            }
        })
    };

    showMsg = ()=>{
        if(this.props.msg&&this.props.msgCode===1) {
            message.success(`Welcome, ${this.props.name}`)
        } else if(this.props.msg&&this.props.msgCode===0){
            message.warn(this.props.msg)
        }
    };

    redirectUtil = ()=>{
        if(this.props.redirectTo) {
            if(this.props.isCourses && this.props.isTimeLine){
                return <Redirect to={this.props.redirectTo}></Redirect>
            } else {
                return null
            }
        }
    }

    render(){

        const { getFieldDecorator } = this.props.form;
        this.showMsg();
        this.props.delMsg();
        return(
            <div className="login-wrap">
                {this.props.redirectTo?<Redirect to={this.props.redirectTo}></Redirect>:null}

                {this.redirectUtil()}
                <div className="wrap">
                    <Form layout='horizontal' style={{width: 300, margin: "0px auto", backgroundColor: 'rgba(0,0,0,0.3)', padding:25, borderRadius: 15}} className="form">
                        <FormItem>
                            {
                                getFieldDecorator('email', {
                                    rules: [
                                        {
                                            required: true,
                                            message: "please input email"
                                        },
                                    ]
                                })(
                                    <Input name="email" prefix={<Icon type='mail'></Icon>} placeholder="email" onChange={this.onChange}/>
                                )
                            }
                        </FormItem>
                        <FormItem>
                            {
                                getFieldDecorator('password', {
                                    rules: [{
                                        required: true,
                                        message: "please input password"
                                    }]
                                })(
                                    <Input name="password" prefix={<Icon type='lock'></Icon>} type='password' placeholder="password" onChange={this.onChange}/>
                                )
                            }

                        </FormItem>
                        <FormItem style={{float: 'left'}}>
                            {
                                getFieldDecorator('remember', {
                                    valuePropName: 'checked', // checkbox的初始化
                                    initialValue: true,
                                })(
                                    <Checkbox className="remember-name">remember username</Checkbox>
                                )
                            }
                        </FormItem>
                        <FormItem>
                                <Button type='primary' onClick={this.handleSubmit}
                                        style={{borderRadius:15, float:'right'}}
                                >Login</Button>
                        </FormItem>
                    </Form>
                </div>
            </div>
        )
    }
}
export default Form.create()(FormLogin)