import React from 'react'
import { Form, Input, Button, message, Icon, Checkbox, Radio, DatePicker, Upload } from 'antd'
import './index.less'
import { connect } from 'react-redux'
import moment from 'moment'
import {delMsg, updateUser} from "../../redux/user.redux";


const FormItem = Form.Item;
const RadioGroup = Radio.Group
const dateFormat = 'YYYY/MM/DD'

@connect(
    state=>state.user,
    {updateUser, delMsg}
)
class StuProfile extends React.Component{

    handleOnchange(e){
        let userInfo = this.props.form.getFieldsValue();
        // console.log(userInfo)
        // if(key=='sex'){
        //     console.log('改变了sex')
        //     this.setState({
        //         sex: val
        //     })
        // }
        // if(key=='type'){
        //     console.log('改变了type')
        //     this.setState({
        //         type: val
        //     })
        // }
        this.setState({
            [e.target.name]: e.target.value
        })
        console.log(this.state)
    };
    handleSubmit = ()=>{
        this.props.form.validateFields((err, values)=>{
            if(!err){
                console.log('提交更新数据...');
                // console.log(this.state);
                console.log(values);
                this.props.updateUser(values);

            }
        })
    };
    render(){

        const { getFieldDecorator } = this.props.form;
        return(
            <div className="profile-wrap">
                <div className="wrap">
                    <Form layout='horizontal' style={{width: 300, margin: "0px auto"}} className="form">

                        <FormItem>
                            {
                                getFieldDecorator('id', {
                                    initialValue: this.props.id?this.props.id:null
                                })(
                                    <Input name='id' type='hidden' placeholder="phone number" onChange={this.handleOnchange.bind(this)}/>
                                )
                            }
                        </FormItem>

                        <FormItem label="Name">
                            {
                                getFieldDecorator('name', {
                                    initialValue: this.props.name?this.props.name:null
                                })(
                                    <Input name='name' prefix={<Icon type='user'></Icon>} placeholder="name" onChange={this.handleOnchange.bind(this)}/>
                                )
                            }

                        </FormItem>

                        <FormItem label="Height(cm)">
                            {
                                getFieldDecorator('height', {
                                    initialValue: this.props.address?this.props.address:null
                                })(
                                    <Input name='height' prefix={<Icon type='home'></Icon>} placeholder="height" type='number' onChange={this.handleOnchange.bind(this)}/>
                                )
                            }
                        </FormItem>

                        <FormItem label="Weight(kg)">
                        {
                            getFieldDecorator('weight', {
                                initialValue: this.props.address?this.props.address:null
                            })(
                                <Input name='weight' prefix={<Icon type='home'></Icon>} placeholder="weight" type='number' onChange={this.handleOnchange.bind(this)}/>
                            )
                        }
                        </FormItem>

                        <FormItem label="Award">
                            {
                                getFieldDecorator('award', {
                                    initialValue: this.props.address?this.props.address:null
                                })(
                                    <Input name='award' prefix={<Icon type='home'></Icon>} placeholder="award" onChange={this.handleOnchange.bind(this)}/>
                                )
                            }
                        </FormItem>

                        <FormItem label="Experience">
                            {
                                getFieldDecorator('experience', {
                                    initialValue: this.props.email?this.props.email:null
                                })(
                                    <Input name="experience" prefix={<Icon type='mail'></Icon>} type='email' placeholder="experience" onChange={this.handleOnchange.bind(this)}/>
                                )
                            }
                        </FormItem>

                        <FormItem label="City">
                            {
                                getFieldDecorator('city', {
                                    initialValue: this.props.address?this.props.address:null
                                })(
                                    <Input name='city' prefix={<Icon type='home'></Icon>} placeholder="city" onChange={this.handleOnchange.bind(this)}/>
                                )
                            }
                        </FormItem>

                        <FormItem label="Phone Number">
                            {
                                getFieldDecorator('phone', {
                                    initialValue: this.props.phone?this.props.phone:null
                                })(
                                    <Input name='phone' prefix={<Icon type='phone'></Icon>} type='number' placeholder="phone number" onChange={this.handleOnchange.bind(this)}/>
                                )
                            }
                        </FormItem>

                        <FormItem label='Gender'>
                            {
                                getFieldDecorator('gender', {

                                })(
                                    <RadioGroup name='gender' onChange={this.handleOnchange.bind(this)} >
                                        <Radio value="1" >male</Radio>
                                        <Radio value="2" >female</Radio>
                                    </RadioGroup>
                                )
                            }
                        </FormItem>

                        <FormItem label='birthday'>
                            {
                                getFieldDecorator('birthday', {
                                    initialValue: moment('2015/01/01', dateFormat),

                                })(
                                    <DatePicker name="birthday" ></DatePicker>
                                )
                            }
                        </FormItem>

                        <FormItem label='User Photo'>
                            {
                                getFieldDecorator('icon', {

                                })(
                                    <Upload
                                        name='icon'
                                        listType='picture-card'
                                        showUploadList={false}
                                        action='/rest/common/updateIcon'
                                    >
                                        <p className='uploadImg'>+</p>
                                    </Upload>
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