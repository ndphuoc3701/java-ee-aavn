package com.example.spearteam.rest;


import com.example.spearteam.rest.request.MemberRequest;
import com.example.spearteam.service.MemberService;
import com.example.spearteam.service.dto.MemberDTO;


import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Stateless
@Path(MemberResource.PATH)
public class MemberResource {
    public static final String PATH = "members";
    @Inject
    private MemberService memberService;

    @Context
    private UriInfo uriInfo;


    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllMembers() {
        if(memberService.getAll().isEmpty()){
            return Response.ok().status(Response.Status.BAD_REQUEST).build();
        }else{
            return Response.status(200)
                    .entity(memberService.getAll()).build();
        }
    }


    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/{MemberId}")
    public Response getMemberById(@PathParam("MemberId") Integer memberId) {
        return Response.status(200)
               .entity(memberService.getById(memberId)).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response addMember(MemberRequest memberRequest) {
        MemberDTO createMember = memberService.createMember(memberRequest);
//        System.out.println(Response.created(appendCurrentUriWith(createMember.getFullName())));
        return Response.ok().entity(createMember).status(Response.Status.CREATED).build();
    }


    @DELETE
    @Path("/{MemberId}")
    public Response deleteMember(@PathParam("MemberId") Integer MemberId) {
        memberService.deleteMemberById(MemberId);

        return Response.ok()
                .build();
    }


    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/{MemberId}")
    public Response updateMember(MemberRequest memberRequest, @PathParam("MemberId") Integer MemberId) {
        MemberDTO updateMember = memberService.updateMember(memberRequest, MemberId);
        return Response.ok().entity(updateMember).status(Response.Status.OK).build();
    }


    private URI appendCurrentUriWith(String fragment) {
        return uriInfo.getAbsolutePathBuilder().path(fragment).build();
    }


}
