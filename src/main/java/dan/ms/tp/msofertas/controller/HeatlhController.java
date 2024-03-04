package dan.ms.tp.msofertas.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/ofertas-precios/health")
public class HeatlhController {

  @GetMapping
  public ResponseEntity<Map<String, String>> health(HttpServletRequest request) {
    // Get the server name
    Map<String, String> res = new LinkedHashMap<>();
    res.put("serverName", request.getServerName());
    res.put("app", "ms-ofertas-precios");
    res.put("status", "OK");
    res.put("timestamp", Instant.now().toString());
    try {
      InetAddress localhost = InetAddress.getLocalHost();
      res.put("serverIp", localhost.getHostAddress());
    } catch (UnknownHostException e) {
      res.put("serverIp", "unknown");
      res.put("status", "ERROR");
      res.put("error", e.getMessage());
      return ResponseEntity.status(500).body(res);
    }
    return ResponseEntity.ok().body(res);
  }

}
