export default {
    formatDate(date){
        if(!date) return '';
        let opt = new Date(date);
        return `${opt.getFullYear()}-${opt.getMonth()+1}-${opt.getDate()} ${opt.getHours()}:${opt.getMinutes()}:${opt.getSeconds()}`;
    }
}