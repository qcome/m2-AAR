var $tabody = $("#tableProjets").find("tbody");
       $("#selectProjets").change(function (e) {
           switch (this.value){
               case "0":
                   $tabody.find('tr').show();
                   break;
               case "1":
                   $tabody.find('tr[data-dirigeant="'+ 1 +'"]').show();
                   $tabody.find('tr[data-dirigeant="'+ 0 +'"]').hide();
                   break;
               case "2":
                   $tabody.find('tr[data-participant="'+ 1 +'"]').show();
                   $tabody.find('tr[data-participant="'+ 0 +'"]').hide();
                   break;
               case "3":
                   $tabody.find('tr[data-competence="'+ 1 +'"]').show();
                   $tabody.find('tr[data-competence="'+ 0 +'"]').hide();
                   break;
               default:
                   break;
           }
       });