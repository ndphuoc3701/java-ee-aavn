package com.example.spearteam.rest;


import com.example.spearteam.entity.Member;
import com.example.spearteam.rest.request.MemberRequest;
import com.example.spearteam.service.MemberService;
import com.example.spearteam.service.dto.MemberDTO;
import com.example.spearteam.service.dto.base.ResponseDTO;


import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.time.LocalDate;
import java.util.Date;

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
    @Path("get_all")
    public Response getAllMembers() {
//        if(memberService.getAll().isEmpty()){
//            ResponseDTO<Member> response = new ResponseDTO<>();
//            response.setMessage("The list is empty !");
//            response.setObject(null);
//            response.setStatusCode(404);
//            response.setCreatedTime("2022-12-08");
//
//            return Response.ok(response).status(Response.Status.NOT_FOUND).build();
//        }else{
//            ResponseDTO<Member> response = new ResponseDTO<>();
//            response.setMessage("Get member success !");
//            response.setObjectList(memberService.getAll());
//            response.setStatusCode(200);
//            response.setCreatedTime("2022-12-08");
//            return Response.ok(response).build();
//        }
        return Response.ok(memberService.getAll()).status(Response.Status.OK).build();
    }


    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("get_member_by_id/{MemberId}")
    public Response getMemberById(@PathParam("MemberId") Integer MemberId) {
        return Response.ok(memberService.getById(MemberId)).build();
    }


    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("add_member")
    public Response addMember(MemberRequest memberRequest) {
        MemberDTO createMember = memberService.createMember(memberRequest);
//        System.out.println(Response.created(appendCurrentUriWith(createMember.getFullName())));
        return Response.ok().entity(createMember).status(Response.Status.CREATED).build();
    }


    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    @Path("delete_member_by_id/{MemberId}")
    public Response deleteMember(@PathParam("MemberId") Integer MemberId) {
        memberService.deleteMemberById(MemberId);
        return Response.ok().status(Response.Status.OK).build();
    }


    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("update_member/{MemberId}")
    public Response updateMember(MemberRequest memberRequest, @PathParam("MemberId") Integer MemberId) {
        MemberDTO updateMember = memberService.updateMember(memberRequest, MemberId);
        return Response.ok().entity(updateMember).status(Response.Status.OK).build();
    }


}
