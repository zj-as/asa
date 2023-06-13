/**
 * <p>infra 模块，主要提供两块能力：</p>
 *
 * <ol>
 *     <li>我们放基础设施的运维与管理，支撑上层的通用与核心业务。例如说：定时任务的管理、服务器的信息等等</li>
 *     <li>研发工具，提升研发效率与质量。例如说：代码生成器、接口文档等等</li>
 * </ol>
 *
 * <p>infra 模块设计：</p>
 *
 * <ol>
 *     <li>Controller URL：以 /infra/ 开头，避免和其它 Module 冲突</li>
 *     <li>DataObject 表名：以 infra_ 开头，方便在数据库中区分</li>
 * </ol>
 *
 * @author asa
 * @since 1.0.1
 */
package pers.zj.asa.module.infra;
