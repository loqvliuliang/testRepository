package com.example.demo.service.service;

import static org.assertj.core.api.Assertions.assertThat;/*********/

/**
 * Created by ll on 2017/7/24.
 */

public class UserServiceTest {
//
//    private DepartmentRepository deptServiceImpl;
//    private DepartmentMapper deptMapper;
//    @Before
//    public void setUp() throws Exception {
//        deptServiceImpl =  PowerMockito.mock(DepartmentRepository.class);
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        Mockito.verifyNoMoreInteractions(deptServiceImpl);
//    }
//
//    @Test
//    public void findUsersByDepartmentId() throws Exception {
//    }
//
//    @Test
//    public void findDepartmentByUser() throws Exception {
//        //1.准备数据
//        Department deptment = Department
//                            .builder()
//                            .id(1L)
//                            .name("测试新增")
//                            .status(1)
//                            .code("8888")
//                            .build();
//        ArgumentCaptor<Department>  deptmentArgumentCaptor = ArgumentCaptor.forClass(Department.class);
//        PowerMockito.when(deptServiceImpl.save(deptmentArgumentCaptor.capture())).thenReturn(deptment);
//        Department actual = new DepartmentServiceImpl(deptMapper,deptServiceImpl).createTest(deptment);
//        assertThat(deptmentArgumentCaptor.getValue().getName()).isEqualTo("测试新增111");
//        assertThat(actual.getId()).isEqualTo(1L);
//        Mockito.verify(deptServiceImpl,Mockito.times(1)).save(deptmentArgumentCaptor.capture());
//    }

}