import { Card, Table, Button, Timeline, Row, Col, Icon, List, Form, Menu, Drawer, InputNumber, Input, Select } from 'antd'
import { connect } from 'react-redux'
import React from 'react'
import './index.less'
import {getTimeLine, getCourses, getTreePlan} from "../../redux/trainerMain.redux";
const FormItem = Form.Item;
const Option = Select.Option;
const SubMenu = Menu.SubMenu;
const columns = [
    {
        title: 'Name',
        dataIndex: 'name',
        key: 'name'
    },
    {
        title: 'Gender',
        dataIndex: 'gender',
        key: 'gender'
    },
    {
        title: 'Age',
        dataIndex: 'age',
        key: 'age'
    },
    {
        title: 'Height',
        dataIndex: 'height',
        key: 'height'
    },
    {
        title: 'Weight',
        dataIndex: 'weight',
        key: 'weight'
    },
    {
        title: 'Phone',
        dataIndex: 'phone',
        key: 'phone'
    },
    {
        title: 'Action',
        key: 'action',
        render: (text, record) => (
            <span>

                <Button><Icon type='user'></Icon>Evaluate</Button>
            </span>
        ),
    }
]
const data = [
    {
        className: '1-A class',
        rank: 'S',
        students: [
            {
                name: 'Jack', //姓名，性别，年龄，身高，体重，电话
                gender: 'male',
                age: '13',
                height: '173',
                weight: '58',
                phone: '13875630988'
            },
            {
                name: 'Roger',
                gender: 'male',
                age: '15',
                height: '173',
                weight: '66',
                phone: '13875236748'
            },
            {
                name: 'Mart',
                gender: 'male',
                age: '12',
                height: '165',
                weight: '55',
                phone: '12546630988'
            },
            {
                name: 'Sussie',
                gender: 'female',
                age: '11',
                height: '149',
                weight: '43',
                phone: '18908958232'
            },
            {
                name: 'Vancy',
                gender: 'female',
                age: '10',
                height: '156',
                weight: '43',
                phone: '17810930988'
            },
        ],
        plans: [
            {trainingTime: '2018-04-03'},
            {trainingTime: '2018-03-31'}
        ]
    },
    {
        className: '1-B class',
        rank: 'A',
        students: [
            {
                name: 'Rogers', //姓名，性别，年龄，身高，体重，电话
                gender: 'male',
                age: '13',
                height: '173',
                weight: '58',
                phone: '13875630988'
            },
            {
                name: 'Steve',
                gender: 'male',
                age: '15',
                height: '173',
                weight: '66',
                phone: '13875236748'
            },
            {
                name: 'May',
                gender: 'female',
                age: '12',
                height: '165',
                weight: '55',
                phone: '12546630988'
            },
            {
                name: 'Linda',
                gender: 'female',
                age: '11',
                height: '149',
                weight: '43',
                phone: '18908958232'
            },
            {
                name: 'Kate',
                gender: 'female',
                age: '10',
                height: '156',
                weight: '43',
                phone: '17810930988'
            },
        ],
        plans: [
            {trainingTime: '2018-05-17'},
            {trainingTime: '2018-05-06'}
        ]
    }
]
const timeLineData = [
    {
        date: '2018-08-06',
        day: 'Monday',
        startTime: '09:00',
        endTime: '11:00',
        courseSite:'Moore Park Tennis court',
        course: 'class 1',
        type:'A'
    },
    {
        date: '2018-08-07',
        day: 'Tuesday',
        startTime: '07:00',
        endTime: '09:00',
        courseSite:'Moore Park Tennis court',
        course: 'class 1',
        type: 'A'
    },
    {
        date: '2018-08-08',
        day: 'Wednesday',
        startTime: '09:00',
        endTime: '11:00',
        courseSite:'UNSW',
        course: 'class 1',
        type: 'S'
    },
    {
        date: '2018-08-10',
        day: 'Friday',
        startTime: '14:00',
        endTime: '16:00',
        courseSite:'Waterloo Coles',
        course: 'class 1',
        type: 'A'
    },
];

@connect(
    state=>state.trainerMain,
    { getCourses, getTimeLine, getTreePlan }
)
class TrainerMain extends React.Component{
    constructor(){
        super();
        this.state = {
            courseList:'',
            treePlan:'',
            timeLine:'',
            isLoading: true,
            drawer: false,
            childDrawer: false,
            visualPlan:[]
        }
    }

    showDrawer = () => {
        this.setState({
            drawer: true,
        });
    };

    onClose = () => {
        this.setState({
            drawer: false,
        });
    };

    onSubmitPlan = () => {
        this.setState({
            drawer: false,
        });
        this.props.form.validateFields((err, values)=>{
            if(!err){
                console.log('提交更新数据...');
                // console.log(this.state);
                console.log(values);
                // this.props.updateUser(values);

            }
        })
    };

    showChildrenDrawer = () => {
        this.setState({
            childDrawer: true,
        });
    };

    onChildrenDrawerClose = () => {
        this.setState({
            childDrawer: false,
        });
    };

    // transferGender = (data)=>{
    //     let rst = {};
    //     for (var i in data){
    //         console.log(i)
    //         if(i === 'gender'){
    //             if(data[i] === '1'){
    //                 rst[i] = 'female'
    //             } else {
    //                 rst[i] = 'male'
    //             }
    //         } else {
    //             rst[i] = data[i]
    //         }
    //     }
    //     return rst
    // }

    renderHistory = (data) => {
        let plans = [];
        data.map(plan=>{
            plans.push(plan.trainingTime)
        })
        return (
            <List
                header={<div>History</div>}
                size='small'
                // bordered
                itemLayout='horizontal'
                dataSource={plans}
                renderItem={item=>(<List.Item>{item}</List.Item>)}
            >
            </List>
        )
    };

    // handleNumInput = (value,name) => {
    //     console.log(value);
    //     console.log(name);
    // }
    test = (e) => {
        console.log(e);
    }
    // handleNumInput = (e) => {
    //     console.log(e.target.value);
    //     console.log(e.target.name);
    //
    //     this.setState({visualPlan: {...this.state.visualPlan}})
    //
    // }

    renderPlan = (data) =>{
        const { getFieldDecorator } = this.props.form;
        return data.map(item => {
            if(item['isParent']===true){
                return(
                    <SubMenu title={item['chTypeName']} key={item['id']}>
                        { this.renderPlan(item['children']) }
                    </SubMenu>
                )
            }
            return (<Menu.Item title={item['chTypeName']} key={item['id']} >
                {/*<NavLink to={item.id}>{ ['chTypeName']}</NavLink>*/}
                {item['chTypeName']}
                {/*<InputNumber*/}
                    {/*name={item['chTypeName']}*/}
                    {/*size="small"*/}
                    {/*style={{float: 'right', "margin-top": 11}}*/}
                    {/*// onChange={(value)=>{this.handleNumInput(value)}}*/}
                    {/*onChange={this.handleNumInput}*/}
                {/*></InputNumber>*/}
                <span style={{float:'right', marginLeft:5}}>{item['unitName']}</span>
                <FormItem label="" style={{float: 'right', width:50}}>
                    {
                        getFieldDecorator(`${item['id']}`, {

                        })(
                            <InputNumber
                                size="small"
                                name={item['chTypeName']}
                                style={{width:50}}
                            />
                        )
                    }

                </FormItem>

            </Menu.Item>)
        })
    }

    renderCourses = (data) => {

        return data.map(course=>{

            return (//  <Card title={`${course.className}-${course.rank}`} style={{width: 700}} className='card-item'>

                <Card title={<p>{`${course.className}`}   <b>{`${course.rank}`}</b></p>} className='card-item'>

                    <Table
                        dataSource={course.students}
                        columns={columns}
                        pagination={false}
                        bordered={true}
                        loading={this.state.isLoading}
                    ></Table>
                    <br/>
                    <Button type='primary' onClick={this.showDrawer}><Icon type='plus-square'></Icon>Make a plan</Button>
                    {this.renderHistory(course.plans)}
                </Card>
            )
        })
    };

    renderTimeLine = (timeLine) => {
        return timeLine.map(course=>{
            return (
                <Timeline.Item
                    color={course.classId===2?'red':'green'}
                >
                    <p>{` ${course.visualTime}`}</p>
                    <p>{`${course.place}`}</p>
                    </Timeline.Item>
            )
        })
    };

    renderTrainTimeOption = (data) => {
        return data.map(time=>{
            return (
                <Option value={time['trainingTime']}>{time['visualTime']}</Option>
            )
        })
    }

    componentWillMount(){
        // send request
        this.props.getCourses();
        this.props.getTimeLine();
        this.props.getTreePlan();
        // get courses from store
        console.log('get courses in WillMount!');
        console.log(this.props.courses);
        // const courseList = this.renderCourses(this.props.courses);
        // this.setState({courses:this.props.courses});
        // const courseList = this.renderCourses(this.state.courses);
        // this.setState({courseList});
        // // get timeLine from store
        // const timeLine = this.renderTimeLine(this.props.timeLine);
        // const timeLine = this.renderTimeLine(timeLineData);
        // this.setState({timeLine});
    }
    componentDidMount(){
        if (this.props.courses){
            console.log('in didmount!')
            this.setState({
                isLoading: false
            })
        }
    }

    // componentDidUpdate(){
    //     if (this.props.timeLine) {
    //         const timeLine = this.renderTimeLine(this.props.timeLine);
    //         this.setState({timeLine});
    //     }
    //     if (this.props.courses) {
    //         const courseList = this.renderCourses(this.props.courses);
    //         this.setState({courseList});
    //     }
    // }
    render(){
        const { getFieldDecorator } = this.props.form;
        return (
            <div>
                <Row className='trainerMain' gutter={8}>
                    {/*{this.props.courses?this.setState({isLoading:false}):null}*/}

                    <Col className='card-wrap' span={17}>
                        {this.renderCourses(this.props.courses)}
                        {/*{this.props.courses}*/}
                    </Col>

                    <Col className='timeLine' span={7}>
                        <Card title="Course plan" loading={this.state.isLoading}>
                            <Timeline mode='left'>
                                {this.renderTimeLine(this.props.timeLine)}
                            </Timeline>
                        </Card>
                    </Col>
                </Row>
                {/*<Row>*/}
                    {/*<Col span={6} offset={3}>*/}
                        {/*<Menu*/}
                            {/*mode='inline'*/}
                        {/*>*/}
                            {/*{this.renderPlan(this.props.treePlan)}*/}
                        {/*</Menu>*/}
                    {/*</Col>*/}
                {/*</Row>*/}

                <Drawer
                    title="Multi-level drawer"
                    width={750}
                    closable={false}
                    onClose={this.onClose}
                    visible={this.state.drawer}
                    placement='left'
                    style={{"padding-bottom":53}}
                >
                    <Row gutter={16}>
                        {/*显示树形结构区域*/}
                        <Col span={15} >
                            <Form layout='horizontal' style={{width: '100%', margin: "0px auto"}} className="form">
                                <FormItem label="Training time" style={{marginLeft:25, paddingBottom:20}}>
                                    {
                                        getFieldDecorator('trainingTime', {

                                        })(
                                            <Select style={{ width:300}}>
                                                {this.renderTrainTimeOption(this.props.trainingTime)}
                                            </Select>
                                        )
                                    }

                                </FormItem>


                                <Menu
                                    mode='inline'
                                >
                                    {this.renderPlan(this.props.treePlan)}
                                </Menu>
                            </Form>
                        </Col>
                        {/*记录做出的选择区域*/}
                        <Col span={9} >
                            <List
                                dataSource={this.state.visualPlan}
                                renderItem={item => (<List.Item>{item}</List.Item>)}
                            >

                            </List>
                        </Col>

                    </Row>

                    <div
                        style={{
                            position: 'absolute',
                            bottom: 0,
                            width: '100%',
                            borderTop: '1px solid #e8e8e8',
                            padding: '10px 16px',
                            textAlign: 'right',
                            left: 0,
                            background: '#fff',
                            borderRadius: '0 0 4px 4px',
                        }}
                    >
                        <Button
                            style={{
                                marginRight: 8,
                            }}
                            onClick={this.onClose}
                        >
                            Cancel
                        </Button>
                        <Button onClick={this.onSubmitPlan} type="primary">
                            Submit
                        </Button>
                    </div>
                </Drawer>

            </div>

        )
    }
}
export default Form.create()(TrainerMain)