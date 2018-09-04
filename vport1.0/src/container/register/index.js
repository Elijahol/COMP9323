import React from 'react'
import { Form, Input, Button, message, Icon, Checkbox, Radio } from 'antd'
import { Redirect } from 'react-router-dom'
import './index.less'
import { connect } from 'react-redux'
import { register, delMsg } from "../../redux/user.redux";


const FormItem = Form.Item;
const RadioGroup = Radio.Group

@connect(
    state=>state.user,
    {register, delMsg}
)

class FormRegister extends React.Component{

    constructor(){
        super();
        this.state={
            name:'',
            password:'',
            email:'',
            role:''
        }
    }
    handleOnchange(e){
        this.setState({
            [e.target.name]: e.target.value
        })
    };
    handleSubmit = ()=>{
        // console.log(this.state);
        this.props.form.validateFields((err, values)=>{
            if(!err){
                this.props.register(this.state);
            }
        })
    };
    render(){

        const { getFieldDecorator } = this.props.form;
        this.props.delMsg();
        return(
            <div className="signup-wrap">
                {this.props.redirectTo? <Redirect to={this.props.redirectTo}></Redirect>:null}
                <div className="wrap">
                    <Form layout='horizontal' style={{width: 300, margin: "0px auto", backgroundColor: 'rgba(0,0,0,0.3)', padding:25, borderRadius: 15}} className="form">
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
                                    <Input name="email" prefix={<Icon type='mail'></Icon>} type='email' placeholder="email" onChange={this.handleOnchange.bind(this)}/>
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
                                    <Input name="password" prefix={<Icon type='lock'></Icon>} type='password' placeholder="password" onChange={this.handleOnchange.bind(this)}/>
                                )
                            }

                        </FormItem>
                        <FormItem>
                            {
                                getFieldDecorator('name', {
                                    rules: [{
                                        required: true,
                                        message: "please input name"
                                    }]
                                })(
                                    <Input name="name" prefix={<Icon type='user'></Icon>} placeholder="name" onChange={this.handleOnchange.bind(this)}/>
                                )
                            }

                        </FormItem>
                        <FormItem>
                            {
                                getFieldDecorator('role', {
                                    rules: [{
                                        required: true,
                                        message: "please input sex"
                                    }]
                                })(
                                    <RadioGroup name="role" style={{color: '#eeeeee'}} onChange={this.handleOnchange.bind(this)}>
                                        <Radio value="2" style={{color: '#eeeeee'}}>student</Radio>
                                        <Radio value="1" style={{color: '#eeeeee'}}>trainer</Radio>
                                    </RadioGroup>
                                )
                            }
                        </FormItem>
                        <FormItem>
                            <Button type='primary' onClick={this.handleSubmit}
                            style={{borderRadius:15}}
                            >Submit</Button>
                        </FormItem>
                    </Form>
                </div>
            </div>

        )
    }
}
export default Form.create()(FormRegister)