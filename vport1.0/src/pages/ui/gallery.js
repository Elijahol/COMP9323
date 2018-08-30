import React from 'react'
import { Card, Row, Col } from 'antd'
import './ui.less'
export default class Gallery extends React.Component{

    render(){
        let suffix = '.png';
        let imgs = [];
        let cnt = 1;
        for(let i = 0; i < 5; i++) {
            var tmp = [];
            for(let j = 0; j < 5; j++) {
                tmp.push(`${cnt}${suffix}`);
                cnt++;
            }
            imgs.push(tmp);
        }
        // const imgs = [
        //     ['1.png', '2.png','3.png','4.png','5.png']
        // ]
        const imgList = imgs.map(list=>list.map(item=>{
            return(
                <Card
                    // cover={<img src={'/gallery'+item} alt=""/>}
                    cover={<img src={"https://picsum.photos/400/800/?image="+Math.floor(Math.random()*500)} alt=""/>}
                    // loading={true}
                    // style={{height: 200}}
                    hoverable={true}
                >

                    <Card.Meta
                        title='React'
                        description='hi'
                    ></Card.Meta>
                </Card>
            )
        }))
        return (
            <div className="card-wrap">
                <Row gutter="10">
                    <Col md={4}>
                        {imgList[0]}
                    </Col>
                    <Col md={4}>
                        {imgList[1]}
                    </Col>
                    <Col md={4}>
                        {imgList[2]}
                    </Col>
                    <Col md={4}>
                        {imgList[3]}
                    </Col>
                    <Col md={4}>
                        {imgList[4]}
                    </Col>
                </Row>
            </div>
        )
    }
}