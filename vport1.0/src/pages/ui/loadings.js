import React from 'react'
import { Card, Button, Spin, Icon, Alert } from 'antd'

export default class Loadings extends React.Component{


    render(){
        const icon = <Icon type='loading'></Icon>;
        return (
            <div>
                <Card title='Spin' className='card-wrap'>
                    <Spin size='small'/>
                    <Spin size='default '/>
                    <Spin indicator={icon} size='large' style={{marginLeft:10}}/>
                </Card>
                <Card title='Content Mask' className='card-wrap'>
                    <Alert
                        message="React"
                        description="Welcome to react"
                        type='warning'
                    >
                    </Alert>

                    <Spin>
                        <Alert
                            message="React"
                            description="Welcome to react"
                            type='info'
                        >
                        </Alert>
                    </Spin>
                </Card>
            </div>
        )
    }
}