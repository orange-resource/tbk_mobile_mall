<template>

    <div class="radius card">
        <slot></slot>
    </div>

</template>

<script>
    export default {
        name: "orange-card"
    }
</script>

<style scoped>

    .card {
        margin: 10px 10px 10px 10px;background-color: #fff
    }

</style>
