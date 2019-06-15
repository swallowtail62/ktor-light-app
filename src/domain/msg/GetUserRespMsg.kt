package com.swallowtail.domain.msg

import com.swallowtail.domain.dto.UserDto

data class GetUserRespMsg(val userList: List<UserDto>)
