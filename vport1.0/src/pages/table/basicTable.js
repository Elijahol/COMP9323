import React from 'react'
import {Card, Table, Button, message, Icon, Checkbox} from 'antd'
import axios from './../../axios'

export default class BasicTable extends React.Component {
    state = {
        dataSource2: []
    };
    componentDidMount(){
        const dataSource = [
            {
                id: '0',
                userName: 'Jack',
                sex: 'male',
                state: 'wow!'
            },
            {
                id: '1',
                userName: 'Jerry',
                sex: 'male',
                state: 'xiix!'
            },
            {
                id: '2',
                userName: 'Micky',
                sex: 'male',
                state: 'ha!'
            },
            {
                id: '3',
                userName: 'Rock',
                sex: 'male',
                state: 'yeah!'
            },
            {
                id: '4',
                userName: 'Duran',
                sex: 'female',
                state: 'shit!'
            },
        ];
        this.setState({
            dataSource
        });
        this.request();
    }

    request = ()=>{


        // axios.get(baseUrl + '/table/list').then((res)=>{
        //     if(res.status === 200 && res.data.code === 0) {
        //         this.setState({
        //             dataSource2: res.data.data
        //         })
        //     }
        // })
        axios.ajax({
            url: '/table/list',
            data: {
                params: {
                    page: 1
                }
            }
        }).then((res)=>{
            if (res.code == 0) {
                this.setState({
                    dataSource2: res.data
                })
            }
        })
    };

    render() {

        const columns = [// 表头一般定义在render里
            {
                title: 'id',
                dataIndex:'id',
            },
            {
                title: 'username',
                dataIndex:'userName',
            },
            {
                title: 'sex',
                dataIndex:'sex',
                render(sex){
                    return sex == 1? 'male': 'female'
                }
            },
            {
                title: 'statue',
                dataIndex:'state',
                render(state) {
                    let config = {
                        1: '🍊',
                        2: '🍎',
                        3: '🍌',
                        4: '🍵',
                        5: '🦁',
                        6: '🍉'
                    }
                    return config[state];
                }
            },
        ]
        return(

            <div>
                <Card title='basic table'>
                    <Table
                        columns={columns}
                        dataSource={this.state.dataSource}
                    >

                    </Table>
                </Card>
                <Card title='dynamic table' style={{margin: '10px 0'}}>
                    <Table
                        columns={columns}
                        dataSource={this.state.dataSource2}
                    >

                    </Table>
                </Card>
            </div>

        )
    }
}