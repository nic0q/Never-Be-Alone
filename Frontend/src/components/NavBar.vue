<style>@import '../assets/navBar.css';</style>
<template>
<div>
  <div class="colorBar">
    <div class="blue"></div>
    <div class="orange"></div>
  </div>
<nav id="nb" class="navbar navbar-expand-lg bg-light">
<div class="container-fluid">
<ul class="navbar-nav mb-2 mb-lg-0">
<li class="nav-item">
<a class="nav-link text-dark" href="/login"><span class="bi-box-arrow-in-right"></span>Mis Denuncias</a>
</li>
<li class="nav-item">
<a class="nav-link text-dark" href="/register"><span class="bi-person-fill"></span>@usach.cl</a>
</li>
<li class="nav-item">
<a class="nav-link text-dark" href="/logout"><span class="bi-box-arrow-right"></span>Cerrar Sesión</a>
</li>
</ul>
</div>
</nav>
</div>
</template>
<style scoped>
#nb{
  background-color: #f5f5f5;
  border-bottom: 1px solid #e5e5e5;
  border-top: 1px solid #e5e5e5;
  padding: 0;
  margin: 0;
}
.colorBar{
  display: flex;
}
.blue{
  width: 100%;
  background-color: blue;
}
.orange{
  width: 100%;
  background-color: orange;
}
</style>
