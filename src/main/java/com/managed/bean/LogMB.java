package com.managed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.model.Log;
import com.service.ILogService;

public class LogMB extends BaseMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private Log Log;

	private List<Log> LogList;

	private ILogService LogService;


	public LogMB(ILogService LogService) {
		setLogService(LogService);
		setLog(new Log());
	}
	public String visualizar(Log Log) {
		setLog(Log);
		return VISUALIZAR;
	}

	public String listaLogs() {
		return LISTAR;
	}

	public String getLabelAcao() {
		return "Visualizar";
	}

	public void reset() {
		setLog(new Log());
	}

	public Log getLog() {
		return Log;
	}

	public void setLog(Log Log) {
		this.Log = Log;
	}

	public List<Log> getLogList() {
		this.LogList = new ArrayList<Log>();
		this.LogList.addAll(getLogService().getAll());
		return LogList;
	}

	public void setLogList(List<Log> LogList) {
		this.LogList = LogList;
	}

	public ILogService getLogService() {
		return this.LogService;
	}

	public void setLogService(ILogService LogService) {
		this.LogService = LogService;
	}
	
}
