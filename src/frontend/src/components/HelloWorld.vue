<template>

</template>

<script>
export default {
    name: 'HelloWorld',
    date()
        return{
            msg:    ''
        }
    }
    mounted(){
        fetch(input:"/api/messages/hello")
            .then((response) => response.text())
            .then((data) => {
                this.nsg = data;
            })
    }
}
</script>