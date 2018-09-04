import React from 'react'
import { Card, Row, Col } from 'antd'
import './ui.less'
export default class ThreePic extends React.Component{

    render(){
        let suffix = '.png';
        let imgs = [];
        let cnt = 1;
        for(let i = 1; i < 4; i++) {

            imgs.push(`tennis-train${i}.jpg`);
        }
        // const imgs = [
        //     ['1.png', '2.png','3.png','4.png','5.png']
        // ]
        const imgList = imgs.map(item=>{
            return(

                    <Card
                    // cover={<img src={'/gallery'+item} alt=""/>}
                    cover={<img src={"/assets/"+item} alt=""/>}
                    // loading={true}
                    style={{weight: 600}}
                    hoverable={true}
                    >


                    </Card>


            )
        })
        return (
            <div className="card-wrap">
                <Row gutter="10">
                    <Col md={3}/>
                    <Col md={6}>
                        {imgList}
                    </Col>
                </Row>
            </div>
        )
    }
}