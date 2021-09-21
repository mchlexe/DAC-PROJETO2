package br.edu.ifpb.api;


import br.edu.ifpb.domain.Produto.ListAllProdutos;
import br.edu.ifpb.domain.Produto.ListByDescricaoProduto;
import br.edu.ifpb.domain.Produto.Produto;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("produtos")
@Produces({MediaType.APPLICATION_JSON})
public class RosourcesDeProdutos {
    
    @Inject
    private ListAllProdutos listProdutos;    
    @Inject
    private ListByDescricaoProduto listByDescricao;
    
    
    @GET
    public List<Produto> listar0 () {
        return this.listProdutos.list();
    }
    
    @GET
    @Path("{descricao}")
    public Response listByDescricao(@PathParam("descricao") String descricao){
        
        List<Produto> produtos = this.listByDescricao.list(descricao);
        
        return Response.ok()
                .entity(produtos)
                .build();        
    }        
    
}