import { Card, Table, Button, Timeline, Row, Col, Icon, List } from 'antd'
import { connect } from 'react-redux'
import React from 'react'
import './index.less'
import {getTimeLine, getCourses} from "../../redux/trainerMain.redux";

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
    { getCourses }
)
export default class TrainerMain extends React.Component{
    constructor(){
        super();
        this.state = {

        }
    }

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

    renderPlans = (data) => {
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
                    ></Table>
                    <br/>
                    <Button type='primary'><Icon type='plus-square'></Icon>Make a plan</Button>
                    {this.renderPlans(course.plans)}
                </Card>
            )
        })
    }
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
    }

    componentWillMount(){
        // send request
        // this.props.getCourses();
        // this.props.getTimeLine();
        // get courses from store
        console.log('get courses in WillMount!');
        console.log(this.props.courses);
        const courseList = this.renderCourses(this.props.courses);
        // this.setState({courses:this.props.courses});
        // const courseList = this.renderCourses(this.state.courses);
        this.setState({courseList});
        // // get timeLine from store
        const timeLine = this.renderTimeLine(this.props.timeLine);
        // const timeLine = this.renderTimeLine(timeLineData);
        this.setState({timeLine});
    }
    render(){

        return (
            <Row className='trainerMain'>
                {/*<Card title='1-A class'>*/}
                {/*<Table ></Table>*/}
                {/*</Card>*/}
                <Col className='card-wrap' span={17}>
                    {this.state.courseList}
                </Col>

                <Col className='timeLine' span={7}>
                    <Card title="Course plan">
                        <Timeline mode='left'>
                            {this.state.timeLine}
                        </Timeline>
                    </Card>
                </Col>
            </Row>
        )
    }


}