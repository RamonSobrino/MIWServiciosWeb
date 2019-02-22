FROM microsoft/aspnet
WORKDIR /
EXPOSE 9092
COPY ./WS.Recomendation.Cities ./WS.Recomendation.Cities
SHELL ["powershell", "-command"]
RUN Get-WebBinding -Port 80 -Name 'Default Web Site' | Remove-WebBinding
RUN New-WebBinding -Name 'Default Web Site' -Port 9092 -IPAddress *
RUN New-WebApplication -Name WS.Recomendation.Cities -Site 'Default Web Site' -PhysicalPath C:\WS.Recomendation.Cities -ApplicationPool DefaultAppPool
