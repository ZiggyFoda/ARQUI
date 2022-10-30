<template>
  <b-container class="bv-example-row">
    <div class="home">
      <img alt="Vue logo" src="@/assets/pu1.jpg" width="40%" height="20%" />
      <hr width="100%" color="#e3b82a" size="50" noshade="noshade" />
      <hr width="100%" color="#fff" size="50" noshade="noshade" />
      <hr width="100%" color="#2C5698" size="50" noshade="noshade" />
      <div class="texto">
        <h1><br />Noticias de AANTIK, mantengase al día</h1>
      </div>
    </div>

    <div v-for="item in items" :key="item">
      <div class="card" style="width: 69rem">
        <h5 class="card-title" v-text="item.Titulo"></h5>
        <b-card-text>
          Fecha: <v-card-text v-text="item.Fecha" /><br /><br />
          <v-card-text v-text="item.Resumen" /><br /><br />
          Fuente: <v-card-text v-text="item.Fuente" />
        </b-card-text>
      </div>
      <br />
    </div>
    <b-col></b-col>
  </b-container>
</template>

<script>
/* eslint-disable */
export default {
  name: "noticias",
  props: {
    msg: String,
  },
  components: {},
  methods: {
    search() {},
  },
  data() {
    return {
      items: [
        {
          Titulo:
            "Cambios en beneficios tributarios para las empresas con la nueva reforma tributaria",
          Resumen:
            "La Dirección de Impuestos y Aduanas Nacionales DIAN controlaba el registro y seguimiento de las solicitudes de deducción a impuestos determinada en la reforma tributaria del 2016 realizada por el gobierno del expresidente Juan Manuel Santos “Deducción por donaciones a entidades no contribuyentes y entidades sin animo de lucro. Hasta el 30% de renta líquida.” (DIAN,2016) Esto hacía referencia a la posibilidad de deducir el valor de la donación del impuesto a la renta. Es decir, las donaciones disminuían la renta líquida por lo que se pagaba un menor impuesto. “Las donaciones que se realicen a las ESAL pertenecientes al régimen tributario especial, así como a las entidades señaladas en los artículos 22 y 23 del ET, dan lugar a descuentos en la declaración del impuesto sobre la renta; estos equivalen al 25 % del valor donado en el respectivo año gravable.” (ESAL | Requisitos para solicitar descuento tributario por donaciones, 2019) Por otro lado, el artículo 256 del ET señalaba que las personas que realizan inversiones en proyectos calificados por el Consejo Nacional de Beneficios Tributarios en Ciencia y Tecnología en Innovación –CNBT– como de investigación, desarrollo tecnológico o innovación tendrían derecho a descontar de su impuesto de renta a cargo el 25 % del valor invertido en dicho proyecto en el período gravable en que se realizó la inversión.",
          Fuente:
            "ESAL | Requisitos para solicitar descuento tributario por donaciones. (2019). BFK. Recuperado 7 de septiembre de 2022, de https://bkf.com.co/esal-descuento-tributario-por-donaciones/#:~:text=Las%20donaciones%20que%20se%20realicen,en%20el%20respectivo%20a%C3%B1o%20gravable.",
          Fecha: "12 agosto 2022",
        },
        {
          Titulo:
            "El Ministerio TIC abre nuevas inscripciones para que familias de estrato 1 y 2 accedan al Internet fijo del programa Hogares Conectados",
          Resumen:
            "El Ministerio de Tecnologías de la Información y las Comunicaciones (MinTIC), en su compromiso de poner la conectividad al alcance de todos los colombianos. El 23 de septiembre de 2022 publica el formulario de preinscripción. El propósito es que familias de estrato 1 y 2, de 21 departamentos, puedan acceder al beneficio de Internet fijo a bajo costo del programa Hogares Conectados. En total, serán 72.000 nuevos hogares de bajos recursos los que se beneficiarán con conectividad hasta el próximo 31 de diciembre de 2022. Las conexiones que se llevarán a cabo hasta el próximo mes de noviembre, estarán a cargo del operador Claro, a través del programa Hogares Conectados brindando servicio de Internet fijo con tarifas sociales, $8.613 para estrato 1, y de $19.074 para estrato 2. Entre los requisitos para poder acceder al beneficio están, vivir en estrato 1, y no haber tenido el servicio de Internet fijo en, por lo menos, los últimos seis meses. Los interesados, podrán preinscribirse diligenciando el formulario en el siguiente link, el cual estará vigente hasta el próximo mes de noviembre de 2022: https://bit.ly/3Uyzyhv",
          Fuente:
            " (El Ministerio TIC Abre Nuevas Inscripciones Para Que Familias de Estrato 1 y 2 Accedan al Internet Fijo Del Programa Hogares Conectados, n.d.) ",
          Fecha: "23 de septiembre de 2022",
        },
        {
          Titulo: "Personas con discapacidad no pagarían peajes",
          Resumen:
            "La noticia nos habla de un beneficio para las personas con discapacidades al no tener que pagar peajes. Esto es debido al grupo de congresistas del partido comunes ya que presentaron un proyecto de ley con este fin. El proyecto busca eximir de las leyes 105/93 a las personas con discapacidades. Lo anterior permitiendo el costo del peaje gratis en todo el territorio nacional, contando con los entes a cargo del Estado, entes privados o los concesionados. (Jurídico, 2022) El proyecto cuenta con dos especificaciones de grupos poblacionales que pueden acceder a este beneficio. El primero siendo las personas que sea dueñas de un vehículo automotor que este adaptado especialmente para ellos y las personas sin discapacidades propietarias de un vehículo y estén a cargo o respondan económicamente por una o varias personas con discapacidad. Solo se debe registrar un vehículo ante el ministerio de trasporte el cual será único permitido para acceder al beneficio y deberá estar libre de multas y al día en el pago de impuestos. Por último, cabe recalcar que quienes estén a cargo de una persona con discapacidades pueden acceder al beneficio solo si se encuentra presente el segundo mencionado. (Jurídico, 2022)",
          Fuente: "Pagina web ámbito jurídico",
          Fecha: "23/09/2022",
        },
      ],
    };
  },
};
</script>

<style scoped>
hr {
  height: 25px;
  margin-top: 5px;
  margin-bottom: 0px;
}
img {
  margin-bottom: 35px;
  margin-top: 30px;
}
p {
  text-align: left;
  margin-top: 5%;
  margin-left: 12%;
  margin-right: 12%;
}
b-row.entidad {
  text-align: left;
  color: rgb(3, 45, 45);
  margin-top: 5%;
  margin-left: 12%;
  margin-right: 12%;
}
b-card-text{
  text-align: left;
  margin-top: 1%;
  margin-left: 5%;
  margin-right: 5%;
  margin-bottom: 1%;
  
}
.card{
  box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}
h5{
    text-align: center;
    margin-top: 1%;
    margin-bottom: 1%;
}
</style>
