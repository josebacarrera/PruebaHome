$(document).ready(beginning);

function beginning(){
  option1();
}

function option1(){
  $('button.borrar')
    .off('click')
    .on('click', borrarId)

  $('button.editar')
    .off('click')
    .on('click', editarId)

  $('.close')
    .off('click')
    .on('click', closeModal)

  $('.save')
    .off('click')
    .on('click', saveModal)

  $('.saveAnadir')
    .off('click')
    .on('click', anadirProducto)

  $('.anadir')
    .off('click')
    .on('click', anadirModal)

  $('a.filtraar')
    .off('click')
    .on('click', filtrarCat)

  $('button.login')
	.off('click')
    .on('click', login)


function preventClick(event){
  event.preventDefault();
  event.stopPropagation();
}

function borrarId(event){
event.preventDefault();
	/*console.log($(this).closest("div.producto").attr("id"));*/
	var id_producto = $(this).closest("div.producto").attr("id");      /* Var x --> url: "/api/producto/"+X, */
	$.ajax({
        url: "/api/producto/"+id_producto,
        method:"DELETE",
        data:{
        },
        success:function(response){
		console.log(response)
		/* console.loh($("div.producto[id =  " + id_producto + "]"))*/
		$("div.producto[id =  " + id_producto + "]").remove();
           }
    });
}

function editarId(event){
event.preventDefault();
	/*console.log($("div#modal"));*/
	  $("div#modal").show('view');    /* Var x --> url: "/api/producto/"+X, */
	  var id_producto = $(this).closest("div.producto").attr("id");
	  	$.ajax({
        url: "/api/producto/"+id_producto,
        method:"GET",
        data:{
        },
        success:function(response){
		console.log(response) 
		$("input#nombre").val(response.producto.nombre);
		$("input#descripcion").val(response.producto.descripcion);
		$("input#precio").val(response.producto.precio);
		/* console.log($("div.producto[id =  " + id_producto + "]"))*/
        $("div#modal").data("id_producto",response.producto.id_producto)

		 }
    });
		
	 
	}
	
	function closeModal(event){
	event.preventDefault();
	$("div.modal").hide('view');
	
	 
	}
	
	function saveModal(event){
	event.preventDefault();
	var id_producto = $("div#modal").data("id_producto");
		  	$.ajax({
        url: "/api/producto/"+id_producto,
        method:"PUT",
        data:{
			nombre:$("input#nombre").val(),
			descripcion:$("input#descripcion").val(),
			precio:$("input#precio").val(),
        },
        success:function(response){
		console.log(response) 
		/* console.log($("div.producto[id =  " + id_producto + "]"))*/
        $("div#modal").hide('view');
		var producto = $("div.producto[id =  " + id_producto + "]"); 
		$("div.producto[id="+id_producto+"] .nombre").html($("input#nombre").val())
		$("div.producto[id="+id_producto+"] .descripcion").html($("input#descripcion").val())
		$("div.producto[id="+id_producto+"] .precio").html($("input#precio").val())
		}
    });

	}
	
	function anadirModal(event){
	event.preventDefault();
	$("div#anadir").show('view')

	}
	
function anadirProducto(event){
event.preventDefault();
	/*console.log($("div#modal"));*/  
   /* Var x --> url: "/api/producto/"+X, */

	  var id_producto = $(this).closest("div.producto").attr("id");
	  	$.ajax({
        url: "/api/producto/",
        method:"POST",
        data:{
		nombre:$("input#nom").val(),
		descripcion:$("input#des").val(),
		precio:$("input#pre").val(),
		stock:$("input#stock").val(),
		img:$("input#img").val(),
		id_categoria:$("input#id_categoria").val()
        },
        success:function(response){
		console.log(response) 
		$("div.padre").append( 
				
				"<div id='"+response.nuevoproducto.id_producto+"' class='col-3 border p-2 producto'>"
		+        	"<h1 class='nombre'>"+$("input#nom").val()+"</h1>"
		+        	"<p class='descripcion'>"+$("input#des").val()+"</p>"
		+        	"<p class='precio'>"+$("input#pre").val()+"</p>"
		+        		"<button id=''class='btn btn-primary editar'>Editar</button>"
		+        		"<button id=''class='btn btn-primary borrar'>Borrar</button>"
		+       "</div>"
		
		)
		
		   option1();
		

		 }
    });
		
	 
	}
	
	function filtrarCat(event){
	event.preventDefault();
	var id_categoria =$(this).attr("id");
	console.log(id_categoria)
	$.ajax({
        url: "/api/producto/filtrar/"+id_categoria,
        method:"GET",
        data:{
        },
        success:function(response){
	console.log(response)
	$("div#padre").html(""); 
	for(var i = 0;i<response.categoria.length;i++){	
		$("div#padre").append( 
			"<div id='"+response.categoria[i].id_producto+"' class='col-3 border p-2 producto'>"
		+        "<h1 class='nombre'>"+response.categoria[i].nombre+"</h1>"
		+        "<p class='descripcion'>"+response.categoria[i].descripcion+"</p>"
		+        "<p class='precio'>"+response.categoria[i].precio+"</p>"
		+        	"<button class=''class='btn btn-primary editar'>Editar</button>"
		+        	"<button class=''class='btn btn-primary borrar'>Borrar</button>"
		+   "</div>"
		
		)
			}
            }

    	});
	
	}
	
	function login(event){
	event.preventDefault();
	$("div#log.modal").show('view');
	
	 
	}

}






