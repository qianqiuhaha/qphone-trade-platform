package com.qf.business.system.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.business.system.mapper.InformMessageMapper;
import com.qf.business.system.service.InformMessageService;
import com.qf.data.system.entity.Employee;
import com.qf.data.system.entity.InformMessage;
import org.springframework.stereotype.Service;

import java.io.Serializable;
@Service
public class InformMessageServiceImpl extends ServiceImpl<InformMessageMapper,InformMessage> implements InformMessageService {
}
